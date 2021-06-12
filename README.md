# PROJETO webstore-carvalho
Este projeto foi desenvolvido com base de estudo para aprimorar o conhecimento do framework QUARKUS, 
se você quiser saber mais sobre o Quarkus, visite seu site: https://quarkus.io/ .


## Executando aplicação no modo dev

Você pode executar seu aplicativo no modo dev que permite a codificação ao vivo usando:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTA:_**  O Quarkus agora vem com uma IU Dev, que está disponível no modo dev apenas em http://localhost:8080/q/dev/.

## Empacotar e executar o aplicativo

O aplicativo pode ser empacotado usando:
```shell script
./mvnw package
```
Ele produz o arquivo `quarkus-run.jar` no diretório`target/quarkus-app/`.
Esteja ciente de que não é um _über-jar_, pois as dependências são copiadas para o diretório `target/quarkus-app/lib/`.

Se você deseja construir um _über-jar_, execute o seguinte comando:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

O aplicativo agora pode ser executado usando `java -jar target/quarkus-app/quarkus-run.jar`.

## Criação de um executável nativo

Você pode criar um executável nativo usando:
```shell script
./mvnw package -Pnative
```

Ou, se você não tiver o GraalVM instalado, pode executar a compilação do executável nativo em um contêiner usando:
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

Você pode então executar seu executável nativo com: `./target/webstore-carvalho-0.0.1-alpha-runner`

Se você quiser saber mais sobre a construção de executáveis ​​nativos, consultet https://quarkus.io/guides/maven-tooling.html.

## Guias relacionados

- RESTEasy JAX-RS ([guide](https://quarkus.io/guides/rest-json)): Estrutura de endpoint REST implementando JAX-RS e mais

## Exemplos fornecidos

### Exemplo RESTEasy JAX-RS

REST é fácil de usar com este recurso Hello World RESTEasy.

[Seção do guia relacionado...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
