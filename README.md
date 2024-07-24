### Projeto API Full

#### Refe.
* Servicos
```
https://www.youtube.com/watch?v=Sun4wXH88V4
```

* Api de farmacia
```
https://www.youtube.com/watch?v=6YfzvYWnwvg
```

* Security
```
https://www.youtube.com/watch?v=O0pmUNUINbs
```

* Kiwify
```
https://pay.kiwify.com.br/mXnHYBK
```

#### Entitis
* Categoria
* Servico
* Usuario
* Taxa

#### tags

git tag v2.0
git push origin v1.0

#### Cofigurando dotEnv
* pom.xml
```
<dependency>
    <groupId>me.paulschwarz</groupId>
    <artifactId>spring-dotenv</artifactId>
    <version>2.3.0</version>
</dependency>
```

* criando arquivo .env
```
DB_BANCO_URL=jdbc:mysql://localhost:3306/api-java
DB_USERNAME=root
DB_PASSWORD=
```

* Configurando o aplication.properties
```
spring.datasource.url=${env.DB_BANCO_URL}
spring.datasource.username=${env.DB_USERNAME}
spring.datasource.password=${env.DB_PASSWORD}
```
