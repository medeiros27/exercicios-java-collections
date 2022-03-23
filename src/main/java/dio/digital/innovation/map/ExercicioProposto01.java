package dio.digital.innovation.map;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.*;

/*
Dada a população estimada de alguns estados do nordeste brasileiro, faça:
 Estado = PE - população = 9.616.621
 Estado = AL - população = 3.351.543
 Estado = CE - população  = 9.187.103
 Estado = RN - população = 3.534.265
 */
public class ExercicioProposto01 {
    public static void main(String[] args) {
        System.out.println("Crie um dicionário que relacione os estados e suas respectivas populações: ");
        Map<String, Integer> populaçãoEstadosBr = new HashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println(populaçãoEstadosBr);

        System.out.println("Exiba todos os estados e suas populações na ordem alfabética: ");
        Map<String, Integer> populaçãoEstadosNE3 = new TreeMap<>(populaçãoEstadosBr);

        System.out.println(populaçãoEstadosNE3);

        Collection<Integer> populacao = populaçãoEstadosBr.values();
        String estadoMaiorPopulacao = "";
        String estadoMenorPopulacao = "";
        for (Map.Entry<String, Integer> entry : populaçãoEstadosBr.entrySet()) {
            if (entry.getValue().equals(Collections.max(populacao))) estadoMaiorPopulacao = entry.getKey();
            if (entry.getValue().equals(Collections.min(populacao))) estadoMenorPopulacao = entry.getKey();
        }
        System.out.printf("Exiba o estado com o menor população (%s) e seu respectivo valor (%d)\n",
                estadoMenorPopulacao, Collections.min(populacao));
        System.out.printf("Exiba o estado com a maior população (%s) e seu respectivo valor (%d)\n",
                estadoMaiorPopulacao, Collections.max(populacao));

        int soma = 0;
        Iterator<Integer> iterator = populaçãoEstadosBr.values().iterator();
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println("Exiba a soma da população desses estados: " + soma);
/*        int soma2 = 0;
       for(Map.Entry<String, Integer> entry : populaçãoEstadosNE.entrySet()) {
           soma2 += entry.getValue();
       }
*/

        System.out.println("Exiba a média da população deste dicionário de estados: " + (soma / populaçãoEstadosBr.size()));
        System.out.println("Remova os estados com a população menor que 4.000.000: ");
        Iterator<Integer> iterator1 = populaçãoEstadosBr.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next() <= 4000000) iterator1.remove();
        }
        System.out.println(populaçãoEstadosBr);

        System.out.println("Apague o dicionario de estados com suas respectivas populações estimadas: ");
        populaçãoEstadosBr.clear();
        System.out.println(populaçãoEstadosBr);

        System.out.println("Confira se a lista está vazia: " + populaçãoEstadosBr.isEmpty());

    }
}