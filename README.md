# Language Helper

[![Open in Visual Studio Codespaces](https://img.shields.io/endpoint?style=social&url=https%3A%2F%2Faka.ms%2Fvso-badge)](https://online.visualstudio.com/environments/new?name=Language%20Helper&repo=seu-usuario/language-helper)

Projeto Java Spring Boot para upload, armazenamento e transcrição de áudios via integração com IA.

**Código atualizado para Spring Boot v3.5.0 e Java 17**

## Sobre o projeto

O Language Helper é uma API backend desenvolvida em Java com Spring Boot, que permite o upload de arquivos de áudio (.mp3) junto com metadados do usuário. O áudio é processado em memória e pode ser enviado para um serviço de IA para transcrição automática.

## Funcionalidades

- Upload de arquivos de áudio (.mp3) via endpoint REST
- Armazenamento dos metadados do áudio e do usuário
- Processamento do arquivo em memória (sem salvar em disco)
- Estrutura pronta para integração com serviços de IA para transcrição de áudio em texto
- Persistência dos dados com Spring Data JPA

## Tecnologias utilizadas

- Java 17
- Spring Boot 3.5.0
- Spring Web
- Spring Data JPA
- Maven

## Estrutura do projeto

```
src/
  main/
    java/
      com/henriqueaf90/language_helper/
        LanguageHelperApplication.java
      controller/
        AudioController.java
      model/
        AudioEntity.java
      repository/
        AudioRepository.java
      service/
        Audioservice.java
    resources/
      application.properties
  test/
    java/
      com/henriqueaf90/language_helper/
        LanguageHelperApplicationTests.java
```

## Como rodar o projeto

1. **Pré-requisitos:**  
   - Java 17+
   - Maven 3.9+

2. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/language-helper.git
   cd language-helper
   ```

3. **Build e execução:**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Acesse a API:**  
   O serviço estará disponível em:  
   `http://localhost:8080/api/audio/upload`

## Exemplo de uso

Faça um POST para `/api/audio/upload` com os seguintes campos (form-data):

- `file`: arquivo .mp3
- `userId`: string
- `title`: string
- `description`: string (opcional)
- `recordingDate`: data/hora no formato ISO (ex: 2025-06-29T15:00:00)

Exemplo usando `curl`:

```bash
curl -X POST http://localhost:8080/api/audio/upload \
  -F "file=@/caminho/para/audio.mp3" \
  -F "userId=123" \
  -F "title=Meu áudio" \
  -F "description=Teste de upload" \
  -F "recordingDate=2025-06-29T15:00:00"
```

## Estrutura das principais classes

- `AudioEntity`: Entidade JPA que representa o áudio e seus metadados.
- `AudioController`: Controller REST para upload de áudio.
- `Audioservice`: Service responsável pelo processamento do arquivo em memória e integração futura com IA.
- `AudioRepository`: Interface JPA para persistência dos dados.

## Próximos passos

- Integrar com serviço de IA para transcrição automática do áudio.
- Implementar autenticação e autorização.
- Adicionar testes automatizados.

## Licença

MIT License © 2025 Henrique Ferreira