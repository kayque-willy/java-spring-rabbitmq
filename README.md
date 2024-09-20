
# Java Spring Boot e RabbitMQ

Esse projeto é uma demonstração de produção e consumo de mensagens do RabbitMQ com o Java Spring Boot

### Execução do RabbitMQ com o Docker

    $ docker compose up -d

## Enviar Mensagens

### Endpoint para geração da mensagem no Client-Backend

    POST localhost:8080/mensagens

#### Objeto da mensagem

    {
       "id": 1,
       "descricao": "descrição",
       "valor": 10
    }

# UI-Manager do RabbitMQ 
O RabbitMQ possui uma interface para administração das filas
## URL
    http://localhost:15672/

## Funcionalidades
Após acessar http://localhost:15672/

### Criar fila

 - Aba -> Queues and Streams

### Criar exchange 

Os exchanges são usados para parametrizar o envio das mensagens para as filas

 1. Aba -> Exchanges -> Add Exchange 
 2. Adicionar o Binding
 3. Vincular o Rountin Key (Parâmetro) com a fila

### Visualizar aplicações conectadas

 - Aba -> Connections 
 - Aba -> Channels

### Visualizar movimentações das mensagens

 - Aba -> Overview 
