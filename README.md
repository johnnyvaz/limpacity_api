# limpacity_api
![Java CI with Maven](https://github.com/johnnyvaz1/limpacity_spring/workflows/Java%20CI%20with%20Maven/badge.svg)

A API recebe os dados e insere no banco, e nela também existem algumas regras do negócio para manter a integridade dos dados.

Embora a solicitação de coleta passa pela fila, na API também é possível inserir essas informações de forma síncrona, isso porque este sistema é que faz a interface com o banco de dados.

