# App Caculadora - Calc viagem
O aplicativo Calculadora e Viagem foi desenvolvido em Java com Android Studio e utiliza o framework Android Jetpack. Ele oferece duas funcionalidades principais: Calculadora geral e Cálculo de Viagem, auxiliando o usuário a estimar consumo de combustível e custo total de deslocamentos.

Estrutura do Aplicativo:
- Linguagem: Java (Android SDK)
- IDE utilizada: Android Studio
- Layouts: XML com ConstraintLayout e LinearLayout
- Componentes principais: MainActivity.java, HomeActivity2.java, ViagemActivity.java, activity_main.xml, activity_viagem.xml

Navegação:
Tela Inicial → Botões principais:
• btCalculadora → abre a tela da Calculadora.
• btViagem → abre a tela do Cálculo de Viagem.
Tela Viagem → Campos de entrada (EditText), botões de ação (btConsulta, btCalcular2, btVoltar2) e área de resultado (TextView).

Funcionalidades:
3.1 Calculadora
Permite operações matemáticas básicas, com interface simples e manipulação de eventos OnClickListener.

Cálculo de Viagem:
Entrada de dados: distância, valor do litro, média de consumo.
Processamento: cálculo do consumo de combustível e do custo total da viagem.
Saída: exibição dos resultados em TextView e avisos via Toast.

Estrutura de Código:
Exemplo de ação (Cálculo de Viagem):
double litrosConsumidos = distancia / mediaKmLitro;
double custoTotal = litrosConsumidos * valorLitro;

String mensagem = String.format(
    "Litros consumidos: %.2f\nCusto total da viagem: R$ %.2f",
    litrosConsumidos, custoTotal
);

tvResultado.setText(mensagem);

Aplicações Relevantes:
Acadêmicas: ensino de desenvolvimento Android, manipulação de layouts XML, boas práticas de programação.
Comerciais: apoio logístico, gestão de transporte, monitoramento de gastos pessoais.

Conclusão
O aplicativo Calculadora e Viagem cumpre duplo papel: acadêmico e comercial. Sua arquitetura clara, código organizado e facilidade de uso tornam-no um exemplo sólido de aplicação móvel com potencial de evolução para projetos reais.



