# Sistema de Priorização de Contato para Ofertas de Energia Sustentável
## Descrição do Projeto

Este projeto foi utilizado para estudar e aplicar estruturas de dados, especificamente árvores AVL, com foco na organização e priorização de informações para o contato com clientes. O sistema desenvolvido em Java simula um ambiente onde uma empresa de energia sustentável pode gerenciar seus clientes e suas interações. A utilização da árvore AVL permite a manutenção de um banco de dados balanceado, garantindo eficiência nas operações de inserção, remoção e consulta de dados.

No contexto desse sistema, a árvore AVL foi empregada para organizar os clientes de acordo com critérios como o valor de consumo de energia ou o interesse por tecnologias sustentáveis, como a instalação de painéis solares. Dessa forma, a estrutura da árvore AVL possibilita uma busca mais rápida e eficiente, promovendo uma interação eficaz com os clientes, permitindo oferecer promoções personalizadas e novos serviços relacionados ao consumo de energia limpa.

Além disso, o projeto exemplifica como estruturas de dados como a árvore AVL podem ser essenciais para o gerenciamento eficiente de grandes volumes de dados, garantindo que o sistema se mantenha rápido e eficiente mesmo com a crescente base de clientes.

## Funcionalidades
O sistema possui as seguintes funcionalidades principais:

### Cadastro de Clientes:

Permite cadastrar novos clientes no sistema.
Os dados dos clientes incluem: nome, CPF, tipo de energia consumida (solar, eólica, elétrica), consumo mensal de energia (em kWh), e a elegibilidade para a oferta de energia sustentável.

### Oferta de Energia Sustentável:

O gerente informa um valor mínimo de consumo de energia, e a partir disso, é criada uma nova árvore AVL com os clientes que atendem a esse critério, organizada pela quantidade de energia consumida de forma decrescente.
A árvore de clientes aptos à oferta é gerada com o objetivo de priorizar aqueles com maior consumo de energia.

### Simulação de Contato com os Clientes:
O gerente pode simular o contato com os clientes da árvore de oferta:
Se o cliente aceitar a oferta, o atributo "Apto para Oferta" será alterado para false.
Caso contrário, o cliente permanece inalterado na árvore de cadastro.

### Consultas ao Cadastro de Clientes:
O gerente pode realizar consultas no cadastro de clientes:
Consulta por CPF: Exibe todos os dados do cliente.
Somatório do Consumo de Energia: Exibe o total de energia consumida por todos os clientes cadastrados.
Quantidade de Clientes com Consumo Acima de um Valor: Exibe a quantidade de clientes que possuem consumo superior a um valor mínimo especificado.

### Encerramento do Programa:
Ao encerrar o programa, o sistema exibe os clientes que não aceitaram a oferta ou não atendem aos critérios de elegibilidade para receber ofertas sustentáveis.

## Estrutura do Projeto
O sistema é composto por uma árvore AVL para organizar os clientes e suas informações. A árvore é utilizada para:

Cadastro de clientes, ordenados pelo CPF.
Gerenciamento das ofertas, com base no consumo de energia.
Realização de consultas e operações de balanceamento de árvores.

## Funcionalidades do Menu
O sistema inclui um menu interativo com as seguintes opções:

### Inscrição de Cliente:
Permite o cadastro de um novo cliente na árvore AVL de cadastro.
### Oferta de Energia Sustentável:
Permite que o gerente informe o valor mínimo de consumo de energia para qualificar o cliente para a oferta de energia sustentável.
### Consulta ao Cadastro:
Submenu para realizar consultas sobre o cadastro de clientes, com as seguintes opções:
### Consulta de cliente por CPF.
Exibição do somatório do consumo de energia de todos os clientes.
Exibição da quantidade de clientes com consumo acima de um valor mínimo.
### Encerrar o Programa:
Finaliza o programa e exibe os clientes que não aceitaram a oferta.

## Exemplos de execução
1. Cadastro de Clientes
Digite nome: João Silva
Digite CPF: 12345678901
Tipo de energia consumida (solar, eólica, elétrica): solar
Informe consumo mensal de energia (kWh): 350.5
2. Oferta de Energia Sustentável
Qual o valor mínimo de consumo de energia (kWh) para a ofertaArvore? 300
3. Consulta de Cliente por CPF
Informe CPF para consulta: 12345678901

## Conclusão
Este sistema oferece uma solução simples e eficaz para gerenciar o cadastro de clientes e priorizar o contato com aqueles que são mais aptos a receber ofertas de tecnologias sustentáveis. Ele utiliza a estrutura de árvore AVL para garantir que os dados sejam organizados e balanceados de maneira eficiente.
