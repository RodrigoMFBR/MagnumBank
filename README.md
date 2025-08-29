Magnumbank - Prova de admissão

Infelizmente não deu para terminar, fazer o JWT, testes e o SWAGGER.

Deve ter uns 70% Pronto

Depois de fazer  o download do projeto

entrar na pasta docker e executar

docker compose up -d

Depois que tiver subido todo o ambiente

Executar o serviço de carga inicial

curl -X POST http://localhost:8081/api/carga-inicial

Vai ter feito a pesquisa e depois já da a carga ma tabela veiculos

Listagem de todas as marcas

curl -X GET http://localhost:8081/api/veiculos/marcas

Filtros de veículos por marca

curl -X GET http://localhost:8081/api/veiculos/marca/{marca}

Atualizar as informações do veiculo

curl -X PUT "http://localhost:8081/api/veiculos/1" -H "Content-Type: application/json" -d '{"modelo":"Fusca 1976","observacoes":"Carro clássico, precisa de restauração"}'

