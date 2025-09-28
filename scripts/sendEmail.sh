#!/bin/bash

# Instala o software necessário para enviar e-mails
echo "Instalando mailutils..."
sudo apt-get update && sudo apt-get install -y mailutils

# Verifica se a variável de ambiente do e-mail foi configurada
if [ -z "$EMAIL_RECIPIENT" ]; then
  echo "Erro: A variável de ambiente EMAIL_RECIPIENT não está definida."
  exit 1
fi

# Pega o status do pipeline do primeiro argumento passado para o script
PIPELINE_STATUS=$1
REPO_NAME=$2
COMMIT_SHA=$3

# Define o assunto e o corpo do e-mail com base no status
if [ "$PIPELINE_STATUS" == "success" ]; then
  SUBJECT="✅ Sucesso: Pipeline para o repositório $REPO_NAME concluído"
  BODY="O pipeline foi executado com sucesso para o commit $COMMIT_SHA."
else
  SUBJECT="❌ Falha: Pipeline para o repositório $REPO_NAME falhou"
  BODY="O pipeline falhou na execução para o commit $COMMIT_SHA. Verifique os logs no GitHub Actions."
fi

# Envia o e-mail
echo "$BODY" | mail -s "$SUBJECT" "$EMAIL_RECIPIENT"

echo "E-mail de notificação enviado para $EMAIL_RECIPIENT."