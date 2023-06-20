FROM ubuntu:latest

# Instalação das dependências necessárias
RUN apt-get update && apt-get install -y gnupg wget

# Importa a chave GPG oficial do MongoDB
RUN wget -qO - https://www.mongodb.org/static/pgp/server-5.0.asc | apt-key add -

# Adiciona o repositório oficial do MongoDB
RUN echo "deb [ arch=amd64,arm64 ] https://repo.mongodb.org/apt/ubuntu $(lsb_release -cs)/mongodb-org/5.0 multiverse" | tee /etc/apt/sources.list.d/mongodb-org-5.0.list

# Instala o MongoDB
RUN apt-get update && apt-get install -y mongodb-org

# Cria o diretório para armazenar os dados do MongoDB
RUN mkdir -p /data/db

# Expõe a porta padrão do MongoDB
EXPOSE 27017

# Define o comando a ser executado ao iniciar o contêiner
CMD ["mongod"]
