# Leitor de PDF em Java

## 📖 Sobre o Projeto

Este é um aplicativo de desktop simples, desenvolvido em Java, que permite aos usuários selecionar um arquivo PDF de seu computador e extrair todo o seu conteúdo de texto. O texto extraído é então exibido no console.

O projeto utiliza a biblioteca **Apache PDFBox** para o processamento de PDFs e o **Swing** para a interface gráfica de seleção de arquivos. Inicialmente desenvolvido como um exercício prático para a disciplina de C14, o código evoluiu para uma arquitetura mais limpa e modular, aplicando o **Princípio da Responsabilidade Única**, onde cada classe possui uma função bem definida no sistema.

## ✨ Funcionalidades

  * **Seleção de Arquivo Local**: Abre uma janela do sistema (`JFileChooser`) para que o usuário possa navegar e selecionar um arquivo `.pdf` em seu computador.
  * **Extração de Texto**: Lê o arquivo PDF selecionado e extrai seu conteúdo textual.
  * **Exibição no Console**: Imprime o texto extraído de forma formatada no console, indicando o início e o fim do conteúdo.
  * **Tratamento de Erros**: Lida de forma adequada com cenários de falha, como a seleção de arquivos inválidos, corrompidos ou criptografados.

## 🛠️ Tecnologias Utilizadas

  * **Java (JDK 24)**
  * **Apache Maven** - Gerenciador de dependências e build
  * **Apache PDFBox** - Biblioteca para manipulação de arquivos PDF
  * **Java Swing** - Para a interface gráfica de seleção de arquivos
  * **JUnit 4** - Para a suíte de testes unitários

## ⚙️ Pré-requisitos

Antes de começar, você precisará ter as seguintes ferramentas instaladas em seu ambiente:

  * [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) - Versão 24 ou superior.
  * [Apache Maven](https://maven.apache.org/download.cgi) - Para gerenciar as dependências e o build do projeto.

## 🚀 Como Executar o Projeto

Siga os passos abaixo para compilar e executar o projeto localmente:

1.  **Clone o repositório:**

    ```bash
    git clone <URL_DO_SEU_REPOSITORIO>
    ```

2.  **Navegue até o diretório do projeto:**

    ```bash
    cd c14
    ```

3.  **Compile o projeto com o Maven:**
    Este comando irá baixar as dependências (`pom.xml`) e compilar o código-fonte.

    ```bash
    mvn clean install
    ```

4.  **Execute o arquivo JAR gerado:**
    Após a compilação, um arquivo `.jar` será criado no diretório `target/`. Execute-o com o seguinte comando:

    ```bash
    java -jar target/c14_dependencies-1.0-SNAPSHOT.jar
    ```

    Ao executar, uma janela para seleção de arquivo será aberta. Escolha um PDF para ver o texto extraído no console.

## 📂 Arquitetura do Código

O projeto foi refatorado para seguir o Princípio da Responsabilidade Única. A lógica é dividida em serviços, tornando o código mais limpo, testável e de fácil manutenção.

A estrutura principal se encontra em `src/main/java/org/reader/`:

  * `Main.java`: Ponto de entrada da aplicação. Sua única responsabilidade é iniciar o processo chamando o `file_selector_service`.
  * `file_selector_service.java`: Responsável por exibir a interface gráfica (`JFileChooser`) para que o usuário selecione um arquivo. Após a seleção, ele delega a leitura para o `file_reader_service`.
  * `file_reader_service.java`: Gerencia o carregamento do arquivo PDF. Ele valida se o arquivo está criptografado e, em caso de sucesso, passa o documento para o serviço de impressão.
  * `file_stripper_service.java`: Sua única função é extrair o conteúdo de texto de um objeto `PDDocument` (o documento PDF carregado).
  * `print_file_service.java`: Formata a saída final, adicionando um cabeçalho e um rodapé, e imprime o texto extraído no console.

## ✅ Testes

O projeto conta com uma suíte de testes unitários desenvolvida com **JUnit** para garantir a qualidade e o correto funcionamento de cada componente.

Os testes estão localizados em `src/test/java/` e cobrem os seguintes cenários:

  * **Testes Positivos**: Verificam o comportamento esperado com arquivos válidos (pequenos, grandes, com caracteres especiais).
  * **Testes Negativos e de Borda**: Garantem que o sistema lida corretamente com situações inesperadas, como:
      * Arquivos nulos ou inexistentes.
      * Arquivos que não são do formato PDF.
      * PDFs criptografados ou corrompidos.
      * Documentos PDF vazios.

-----
