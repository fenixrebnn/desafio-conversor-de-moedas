# Conversor de Moedas via Console — Java 21

## Descrição

Projeto simples em Java 21 para converter valores entre diferentes moedas (BRL, USD e EUR) com taxas de câmbio atualizadas em tempo real por meio de uma API  (`exchangerate.host`). A interação é feita via console, oferecendo um menu com 6 opções distintas de conversão.

---

## Funcionalidades

- Menu interativo via console com opções para converter entre Real Brasileiro (BRL), Dólar Americano (USD) e Euro (EUR).  
- Consulta dinâmica da taxa de câmbio atual, garantindo conversões precisas e atualizadas.  
- Tratamento de erros para lidar com falhas na API ou entrada inválida do usuário.

---

## Tecnologias

- Java 21  
- Biblioteca [Gson](https://github.com/google/gson) para manipulação de JSON  
- API pública `https://api.exchangerate.host` (não requer chave de acesso)

---

## Como executar

1. Clone este repositório ou baixe os arquivos `.java`.  
2. Garanta que a dependência Gson esteja adicionada no seu projeto.

### Usando Maven

Adicione a dependência no seu `pom.xml`:

```xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.8.9</version>
</dependency>
