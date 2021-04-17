#language: pt

Funcionalidade: Adicionando Nova Questão

Esquema do Cenario: <CT> - <Descrição do cenario> 

    Quando eu clico em ADD NEW QUESTIONS
    Entao o sistema deve mostrar um alerta de erro
    # ERROR! You must be logged in to submit a trivia question.
    
    Exemplos:
	| CT 	| Descrição do cenario				       | 
	| 01  | Add nova questão estando deslogado |