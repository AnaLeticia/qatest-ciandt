#language: pt

Funcionalidade: Busca no Banco de Questões

Esquema do Cenario: <CT> - <Descrição do cenario> 
	Dado que navego para a página de busca do banco de questões
	E digito 'Science: Computers' no campo de busca
	Quando clico no botão de buscar 
	Entao visualizo uma mensagem de erro com o texto 'No questions found.

Exemplos:
	| CT 	| Descrição do cenario					| 
	| 01  | Busca por Questão Inexistente |

#Precisamos fazer uma busca na categoria por Science: Computers e verificar se a listagem de questões está com 25 itens e se o controle de paginação irá aparecer.

Esquema do Cenario: <CT> - <Descrição do cenario> 
	Dado que navego para a página de busca do banco de categoria
	E digito 'Science: Computers' no campo de busca
	Quando clico no botão de buscar 
	Entao verifico uma listagem de questões com "<numero>" itens
	E verifico o controle de paginação

Exemplos: 
	| CT 	| Descrição do cenario 					|  numero  |
	| 02  | Busca por Categoria						|  25 		 |
 
 # Teste por busca de usuário
 
 Esquema do Cenario: <CT> - <Descrição do cenario> 
	Dado que navego para a página de busca do banco de usuário
	E digito 'DrAwesome' no campo de busca
	Quando clico no botão de buscar 
	Entao visualizo uma listagem de questões com "<numero>" itens

Exemplos: 
	| CT 	| Descrição do cenario 					|  numero  |
	| 03  | Busca por Usuário 						|  2   		 |