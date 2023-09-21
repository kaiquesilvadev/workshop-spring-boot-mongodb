# Workshop Spring Boot com MongoDB

**Descrição do Projeto**

Este espaço foi criado com o objetivo de documentar e compartilhar minha jornada de aprendizado com o Spring Boot. O Spring Boot é conhecido por sua simplicidade e eficiência, sendo uma ferramenta poderosa para a construção de aplicativos Java. Além disso, estamos explorando o uso de bancos de dados NoSQL, que oferecem flexibilidade e escalabilidade em ambientes de armazenamento de dados.

![Diagrama de Classes](https://github.com/kaiquesilvadev/workshop-spring-boot-mongodb/blob/main/Captura%20de%20tela%202023-09-21%20185349.png)

## Padrão de Camadas

![Padrão de Camadas](https://github.com/kaiquesilvadev/workshop-spring-boot-mongodb/blob/main/Captura%20de%20tela%202023-09-21%20185426.png)

No projeto, segui um padrão de camadas típico em um aplicativo Spring Boot com MongoDB. As principais camadas incluem:

- **Camada de Controle (Controller):** Responsável por receber solicitações HTTP, interagir com o usuário e chamar os serviços apropriados.

- **Camada de Serviço (Service):** Contém a lógica de negócios do aplicativo. Os serviços são chamados pelos controladores e interagem com os repositórios.

- **Camada de Repositório (Repository):** Responsável pela comunicação com o banco de dados MongoDB. Ela fornece métodos para acessar e manipular os dados armazenados no banco de dados.

- **Camada de Modelo (Model):** Representa as entidades do domínio do aplicativo, como classes de dados e objetos de transferência de dados (DTOs).

## Começando

Siga as instruções abaixo para configurar e executar o projeto em sua máquina local.

### Pré-requisitos

- Java Development Kit (JDK)
- MongoDB instalado e em execução
- IDE de sua escolha (recomendado: IntelliJ IDEA ou Spring Tool Suite)

### Instalação

1. Clone este repositório para o seu ambiente de desenvolvimento local:

```bash
git clone https://github.com/kaiquesilvadev/workshop-spring-boot-mongodb.git

````

2. Navegue até o diretório do projeto:

```bash
cd workshop-springboot3-jpa

```

3. Execute o aplicativo Spring Boot:

```bash
./mvnw spring-boot:run

```

## Contribuições

Se você deseja contribuir para este projeto, siga estas etapas:

1. Fork o projeto
2. Crie uma branch para a sua feature (`git checkout -b feature/sua-feature`)
3. Commit suas mudanças (`git commit -m 'Adicione sua feature'`)
4. Push para a branch (`git push origin feature/sua-feature`)
5. Abra um Pull Request

Por favor, certifique-se de seguir as diretrizes de contribuição.

