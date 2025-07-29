
# Clean Architecture com Java e Quarkus

- `escolacore` - base da implementação em clean architecture
- `webapi` - API RESTful usando Quarkus

## Recomendações

Usar o [mise](https://mise.jdx.dev/) para gerenciar as ferramentas de desenvolvimento. O arquivo `mise.toml`, na raiz de cada um dos projetos, é usado para configurar automaticamente as ferramentas do ambiente de desenvolvimento. Testado em macOS, linux e windows.

## Instruções para rodar

### Rodar automaticamente: 

`make rundev`

### Rodar manualmente

Abrir dois terminais, e em cada um deles, entrar em cada um dos paths acima. Siga os passos abaixo na sequência.

No path `escolacore`, executar o comando `mvn clean install`. **Importante: este deve rodar antes do `webapi`, porque o webapi depende dele para executar.**

No path `webapi`, executar o comando `mvn clean quarkus:dev`. Ao iniciar este projeto pela primeira vez, será criado um banco de dados sqlite em `escola/database/escola.db`, já com dados de exemplo populados.



### Usando com o IDEA

Se estiver usando o IDEA, instale o plugin de workspaces, e abra o projeto no path `escola`, e este projeto carrega automaticamente os outros projetos.

### Usando com o VSCode

Se estiver usando o VSCode, abra o Visual Studio Code, selecione File > Open Workspace from File, e selecione o arquivo `escola.code-workspace` no path code-workspace.

## Endpoints implementados

- POST `/pessoa`
- GET `/pessoa/{id}`

## Notas

Sempre que alterar o projeto `escolacore`, execute novamente o comando `mvn clean install`, para publicar a nova versão do pacote.

Para refletir o estado na webapi, pare o devserver do Quarkus e execute o comando `mvn clean quarkus:dev` novamente.
