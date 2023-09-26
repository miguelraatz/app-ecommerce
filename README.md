### App Ecommerce

<a href="https://www.figma.com/file/ZNsxwdtXIch5BGJLzOlthy/Untitled?type=design&node-id=0-1&mode=design&t=5bo8aUnwHR5XFtlg-0" target="_blank">Protótipo</a>
Figma


___
Para iniciar o projeto, siga os passos abaixo:

```bash
git clone git@github.com:miguelraatz/app-ecommerce.git
```
Entre no diretório:
```bash
cd teste-sovis
```
___ 

<details><summary>Iniciando Backend e banco MySQL:gear:</summary>

Entre no diretório:
```bash
cd backend
```
Instale as dependências:
```bash
mvn install
```
Execute o docker-compose:
```bash
docker-compose up
```
</details>

___ 

<details><summary>Iniciando Frontend :computer:</summary>

Entre no diretório:
```bash
cd ..
```
```bash
cd frontend
```
Instale as dependências:
```bash
npm install
```
Inicie o projeto:
```bash
npm run dev
```
</details>

___

<details><summary>Documentação API :test_tube:</summary>

**BASE_URL**: `http://localhost:8080/endpoint`

| Endpoints      | Método | Descrição                                                           | Body                                                                                             |
| -------------- | ------ | ------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------ |
| `/register`       | POST   | Registra um novo usuário | `{ "name": string, "email": string, "password": string }`                                                        |
| `/login`     | POST   | Realiza o login no app.                                     | `{ "name": string, "email": string, "password": string }`      |
| `/home`     | GET   | Recupera todos os produtos do banco.                                     |  
| `/home` | POST   | Adiciona produto ao carrinho.      | `{ "name": string, "description": string, "price": number, "image": string } `                                          |
| `/email/send`     | POST   | Envia e-mail após a compra.                                     | `{ "to": string, "subject": string, "message": string }`      |
| `/cart` | GET   | Recupera itens carrinho.      |                                           |
| `/cart` | DELETE   | Deleta todos os itens do carrinho.      |                                           |
| `/cart/{userId}/productId` | DELETE   | Deleta item do carrinho.      |                                           |
</details>

___

<details><summary>Tecnologias utilizadas :computer:</summary>

### Frontend:
```bash
Vite -
# Desenvolvimento Rápido: Vite oferece um ambiente de desenvolvimento extremamente rápido, com recarregamento instantâneo e tempos de compilação mínimos, acelerando o ciclo de desenvolvimento.

# HMR (Hot Module Replacement): Oferece HMR integrado, permitindo que as mudanças de código sejam refletidas instantaneamente no navegador sem recarregar a página.

# Configuração Simplificada: A configuração inicial é minimalista e fácil de entender, o que facilita a configuração do projeto React.
```

```bash
ReactJS -
# Reatividade: Atualizações de interface de usuário eficientes e responsivas devido à sua abordagem baseada em componentes.

# Reutilização de Componentes: Facilita a criação e reutilização de componentes em diferentes partes do aplicativo.
```

```bash
React Router Dom -
# Roteamento Declarativo: Facilita a criação de rotas e navegação declarativa dentro de um aplicativo React.

# Navegação Suave: Permite transições de página suaves e gerenciamento de histórico de navegação sem recarregar a página inteira.
```

```bash
Toastify -
# Notificações Amigáveis: Facilita a exibição de notificações elegantes e amigáveis para o usuário em resposta a eventos no aplicativo.

# Permite personalizar facilmente o estilo e o comportamento das notificações, de acordo com as necessidades de design do aplicativo.
```

### Backend

```bash
Java Spring Boot -
# Eficácia no Desenvolvimento: O Spring Boot simplifica o desenvolvimento de aplicativos Web, fornecendo configurações padrão e um ambiente de desenvolvimento rápido.

# Integração com Banco de Dados: Oferece suporte robusto para integração com bancos de dados, permitindo a criação de aplicativos com facilidade.
```

```bash
Java Data JPA -
# Abstração de Banco de Dados: O Spring Data JPA oferece uma abstração de alto nível para interagir com bancos de dados relacionais.

# Consultas Dinâmicas: O Spring Data JPA suporta a criação de consultas dinâmicas com base em métodos de repositório, proporcionando flexibilidade na recuperação de dados.

# Repositórios Automatizados: Gera automaticamente repositórios CRUD (Create, Read, Update, Delete) a partir de interfaces, economizando tempo de desenvolvimento.
```

```bash
Java Boot DevTools -
# Desenvolvimento Rápido: O Spring Boot DevTools acelera o ciclo de desenvolvimento ao permitir recarregamento automático de código e recursos quando alterações são detectadas.

# Recarregamento Automático: O DevTools detecta mudanças no código fonte, recompila automaticamente e atualiza o aplicativo em tempo real, economizando tempo de desenvolvimento.
```

```bash
Java Boot Starter Email -
# Simplificação do Envio de Emails: O Spring Boot Starter Email simplifica o processo de envio de emails em aplicativos, fornecendo configurações predefinidas para os serviços de email.

# Integração Fácil: Oferece integração fácil com serviços de email populares, como SMTP e Gmail, por meio de configurações simples.
```

```bash
Docker -
# Isolamento e Portabilidade: O Docker permite empacotar o aplicativo, suas dependências e o banco de dados em contêineres isolados. Isso garante que todas as configurações e dependências estejam contidas em um ambiente consistente, tornando-o altamente portátil. 
```

</details>