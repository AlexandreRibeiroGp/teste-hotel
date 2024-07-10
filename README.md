Hotel Application README
Requisitos de Sistema
Java Development Kit (JDK) - Versão 11 ou superior.
Maven - Ferramenta de gestão 
PostgreSQL - Banco de dados relacional.
Postman - Para testar as APIs REST.
Instalação e Configuração

1. Instalação do PostgreSQL
Baixe e instale o PostgreSQL 
2. Configuração do PostgreSQL
Crie um banco de dados no PostgreSQL para a aplicação.
Crie um usuário com permissões adequadas para o banco de dados.
3. Scripts de Criação de Tabelas
Utilize os scripts SQL fornecidos para criar as tabelas necessárias no banco de dados.

4. Configuração do Maven
Certifique-se de que o Maven esteja instalado corretamente no seu sistema.

6. Configuração da Aplicação
Clone o repositório da aplicação.
Configure as credenciais do banco de dados no arquivo application.properties com as informações do seu banco de dados PostgreSQL.
Exemplo de application.properties:

properties
Copiar código
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update

Testando as APIs com Postman
utilizar as chamadas do postmand fornecida na collection
