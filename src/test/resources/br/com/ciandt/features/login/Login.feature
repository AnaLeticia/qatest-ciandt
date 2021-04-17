#language: pt
@Login

Funcionalidade: Acessar a Opção Login

Esquema do Cenario: <CT> - <Descrição do cenario> 

		Dado que eu preencho o login com credenciais invalidas
    Quando eu clico em Sign In
    Entao o sistema deve mostrar um alerta de login invalido
 
    Exemplos:
	| CT 	| Descrição do cenario |
	| 01  | Login Inválido			 |

