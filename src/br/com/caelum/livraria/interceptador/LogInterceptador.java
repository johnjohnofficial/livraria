package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {
	
	/*
	 * O método intercepta() fará o monitoramento do tempo de acesso ao banco de dados pegando 
	 * o tempo quando o método é invocado e subtraindo do tempo quando o método é finalizado.
	 */
	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception {
				
		long millis = System.currentTimeMillis();
				
		Object o = context.proceed();
						
		String nomeClasse = context.getClass().getSimpleName();
		String nomeMetodo = context.getMethod().getName();
						
		System.out.println("[ INFO ] " + nomeClasse + "->" + nomeMetodo);					// imprime o nome da classe e o método interceptados
		System.out.println("[ INFO ] Tempo gasto no acesso ao BD: "
					+ (System.currentTimeMillis() - millis) + "ms");		// imprime o tempo gasto para acessar o BD 
		
		return o;
	}

}
