Aplicação desenvolvida em Java-RMI para gerenciamento de anotações - Postit

Para executar é necessário ter instalado um MySQL Server 5.5 ou superior rodando na porta 3306 na máquina onde a aplicação servidor está hospedada.

Para configuração do banco, usuário e tabelas basta executar o arquivo Script_database.sql que está armazenada na raiz do projeto. Será criado um banco postit com as tabelas necessárias e um usuário com direito de acessar apenas este banco. NÃO ALTERE ESSE ARQUIVO.

O serviço RMI será iniciado na porta 1099 na máquina onde o servidor é hospedado.

Atualmente, o projeto Client+Server pode está sendo rodando em JVMs diferentes, mas precisa está rodando na mesma máquina, pois o endereço está armazenado diretamente no código fonte(hardcoded).

O padrão utilizado para o desenvolvimento foi o MVC. Então os pacotes estão estruturados da forma orientada. Basta seguir o padrão que é possível encontrar as classes por suas responsabilidades.

Ao executar a aplicação a primeira vez, é necessário criar um usuário para utilização. Então, basta digitar qualquer username e password para criação do usuário.

Link para github:
https://github.com/jpsilvaj/Postit

Ferramentas utilizadas:
Eclipse Luna – 4.4 - IDE
Git 1.8.3 – Controle de versão
Github – hospedar código fonte
Hibernate-4.3.8 - ORM
Miglayout-4.0 - View
MySQL-Connector-java.5.1 – Driver para banco de dados
