# Golden Raspberry Awards
API desenvolvida em JAVA com Spring Boot. Utilizando JDK 11.

```diff
- Necessário JAVA 11 para execução do projeto. https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html
```
Verificar versão do JAVA com ```java -version```.

## Instruções para execução
- Para execução dos testes, executar a partir da pasta raiz do projeto, via linha de comando:  
```mvnw clean test```

- Para execução da aplicação, executar a partir da pasta raiz do projeto, via linha de comando:  
```mvnw spring-boot:run```

## Utilização da API
- Ao iniciar a aplicação os dados podem ser consultados, via browser, no endpoint http://localhost:8080/awardIntervals , ou realizando requisição GET para mesma URL.

## Troca dos dados de entrada
- Para alterar o conjunto de dados substituir o arquivo ```movielist.csv``` no diretório ```main/resourses/static```.   
  - Para leitura correta, arquivo deve ser separado por ```;``` e possuir cabeçalho, na mesma ordem do arquivo original
