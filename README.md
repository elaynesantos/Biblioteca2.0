# Sistema de Gerenciamento de Biblioteca

Este projeto é um sistema de gerenciamento de biblioteca desenvolvido em Java, utilizando o padrão de projeto DAO (Data Access Object) para a abstração do acesso a dados e JDBC (Java Database Connectivity) para a conexão com o banco de dados MySQL.

## Funcionalidades

- Cadastro, consulta e listagem de usuários.
- Cadastro, consulta e listagem de livros.
- Busca de usuários por diferentes critérios (nome, tipo, e-mail).
- Listagem de livros por fornecedor.
- Operações de CRUD (Create, Read, Update, Delete) para entidades do sistema.

## Tecnologias Utilizadas

- **Linguagem:** Java
- **Banco de Dados:** MySQL
- **Conexão:** JDBC (Java Database Connectivity)
- **Padrão de Projeto:** DAO (Data Access Object)

## Estrutura do Projeto

O projeto está organizado em diferentes classes para garantir a modularidade e a manutenção eficiente do código:

1. **Classe `Biblioteca`:** Responsável pela interface principal com o usuário e pelo menu de opções.
2. **Classe `ConexaoBD`:** Gerencia a conexão com o banco de dados MySQL.
3. **Classes `UsuarioDAO` e `LivroDAO`:** Contêm as operações específicas de acesso a dados para as entidades Usuário e Livro, respectivamente.

## Banco de Dados

A modelagem do banco de dados utiliza um modelo relacional com tabelas interconectadas. As principais tabelas são:

- **Tabela `Usuario`:** Armazena informações sobre os usuários da biblioteca.
- **Tabela `Livro`:** Armazena informações sobre os livros disponíveis na biblioteca.

Exemplo de criação das tabelas:

```sql
CREATE TABLE Usuario (
    ID_Usuario INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Tipo VARCHAR(50),
    Email VARCHAR(100)
);

CREATE TABLE Livro (
    ID_Livro INT AUTO_INCREMENT PRIMARY KEY,
    Titulo VARCHAR(200),
    Autor VARCHAR(100),
    Fornecedor VARCHAR(100)
);
