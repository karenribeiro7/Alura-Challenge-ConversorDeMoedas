# Conversor de Moedas

Bem-vindo ao **Conversor de Moedas**, uma aplicação em Java que permite converter valores entre diferentes moedas, utilizando a [ExchangeRate-API](https://www.exchangerate-api.com/) para obter as taxas de câmbio mais recentes. A aplicação possui um histórico das conversões realizadas, possibilitando a consulta das transações já efetuadas.

## Funcionalidades

- Converter valores entre as seguintes moedas:
  - Real Brasileiro (BRL)
  - Peso Argentino (ARS)
  - Dólar (USD)
  - Peso Colombiano (COP)
  - Boliviano (BOB)
  - Peso Chileno (CLP)
  - Euro (EUR)
- Exibir um histórico detalhado das conversões realizadas.
- Manipulação e tratamento de exceções como `ValorInvalidoExcecao`, `IOException`, `InterruptedException` e `InputMismatchException`.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada.
- **ExchangeRate-API**: Serviço de API utilizado para obter as taxas de câmbio.

## Como Executar a Aplicação

1. Certifique-se de ter o [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) instalado em sua máquina.
2. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/conversor-moedas.git
   ```
3. Navegue até o diretório do projeto:
   ```bash
   cd conversor-moedas
   ```
4. Compile o projeto utilizando o `javac`:
   ```bash
   javac -d bin src/br/com/alura/conversormoedas/principal/Main.java
   ```
5. Execute a aplicação:
   ```bash
   java -cp bin br.com.alura.conversormoedas.principal.Main
   ```

## Como Utilizar

1. Ao iniciar a aplicação, será exibido um menu com as opções de conversão disponíveis.
2. Escolha uma opção digitando o número correspondente à conversão desejada.
3. Insira o valor a ser convertido.
4. A aplicação mostrará o valor convertido e armazenará a conversão no histórico.
5. Para visualizar o histórico, selecione a opção "13" no menu.

## Tratamento de Exceções

A aplicação trata os seguintes tipos de exceções:

- `ValorInvalidoExcecao`: Lançada quando um valor inválido é fornecido para conversão.
- `IOException`: Lançada quando há problemas ao acessar a API.
- `InterruptedException`: Lançada caso a execução da thread seja interrompida.
- `InputMismatchException`: Lançada em caso de entrada de dados incorreta pelo usuário.

## Personalização

Você pode adicionar mais moedas ao enum `Moeda` na pasta `util` e ajustar a lógica da aplicação para incluir mais opções de conversão

## Contribuição

Sinta-se à vontade para contribuir para este projeto abrindo issues e pull requests. Sugestões e melhorias são sempre bem-vindas!


