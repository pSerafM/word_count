# MapReduce - Contagem de palavras da Bíblia

Atividade de Java Maven para aplicar o conceito de MapReduce sobre o arquivo `bible.txt`.

## Estrutura

- `Main.java`: lê o arquivo, executa as etapas Map e Reduce e exibe o resultado.
- `Map.java`: transforma cada palavra em um par `<palavra, 1>`.
- `Reduce.java`: agrupa os pares pela palavra e soma as ocorrências.
- `bible.txt`: dataset fornecido para a atividade.
- `resultado.txt`: gerado automaticamente após a execução.

## Exemplo do funcionamento

Para uma entrada:

```text
god created god
```

A etapa Map gera:

```text
<god, 1>
<created, 1>
<god, 1>
```

A etapa Reduce gera:

```text
god 2
created 1
```

## Execução no IntelliJ

1. Abra a pasta do projeto no IntelliJ IDEA.
2. Aguarde o Maven carregar o `pom.xml`.
3. Confirme que `bible.txt` está na raiz do projeto.
4. Execute `Main.java`.
5. O programa exibirá as 10 palavras mais frequentes e criará `resultado.txt`.

## Observação

A normalização transforma as palavras para letras minúsculas e remove pontuação. Assim, por exemplo, `God`, `god` e `god,` são contabilizados como `god`.
