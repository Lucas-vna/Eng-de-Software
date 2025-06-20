graph TD
    subgraph "Frontend (Aplicação Web - ex: React, Angular, Vue.js)"
        A[Portal do Professor]
        B[Portal do Aluno]
    end

    subgraph "Backend (API Gateway)"
        C[Gateway de API]
    end

    subgraph "Microsservicos/Modulos do Backend"
        D[Servico de Autenticacao]
        E[Servico de Upload e Processamento de Documentos]
        F[Servico de Geracao de Simulados]
        G[Servico de Resposta e Avaliacao]
    end

    subgraph "Google Cloud Platform (GCP)"
        H[Cloud Storage Bucket<br>Armazenamento de Documentos]
        I[API do Gemini<br>Modelo de Linguagem]
    end

    subgraph "Banco de Dados"
        J[Banco de Dados SQL/NoSQL<br>]
    end

    %% Conexões do Professor
    A -- 1 Login/Cadastro --> C
    A -- 2 Upload do Documento  --> C
    C -- Encaminha --> D[Verifica autenticacao]
    C -- 3 Encaminha Upload --> E

    %% Fluxo de Criação do Simulado
    E -- 4 Gera URL Pre-assinada --> H
    A -- 4.1 Faz upload direto para --> H
    H -- 5 Notifica via gatilho  --> E
    E -- 6 Extrai o texto do documento --> E
    E -- 7 Envia texto para --> F
    F -- 8 Monta o Prompt para o Gemini --> I
    I -- 9 Retorna Questoes  --> F
    F -- 10 Salva o Simulado  --> J

    %% Conexões do Aluno
    B -- 11 Login/Acessa Simulado --> C
    C -- Encaminha --> D
    C -- 12 Pede Simulado --> F
    F -- 13 Busca Simulado --> J
    J -- 14 Retorna Simulado --> F
    F -- 15 Envia Simulado para --> B
    B -- 16 Aluno responde o simulado --> B
    B -- 17 Envia Respostas --> C
    C -- 18 Encaminha Respostas --> G

    %% Fluxo de Avaliação Diagnóstica
    G --  Salva respostas do aluno --> J
    G -- 20 Busca Questoes e Respostas Corretas --> J
    G -- 21 Compila dados de desempenho do aluno --> G
    G -- 22 Monta o Prompt para Avaliacao --> I
    I -- 23 Retorna Avaliacao Diagnostica --> G
    G -- 24 Salva Avaliacao no Banco de Dados --> J
    G -- 25 Disponibiliza Avaliacao para --> B
    A -- 26 Professor visualiza desempenho da turma --> C
    C -- Encaminha --> G
    G -- Busca e retorna dados consolidados --> J


    style A fill:#000000,stroke:#333,stroke-width:2px
    style B fill:#000000,stroke:#333,stroke-width:2px
    style C fill:#000000,stroke:#333,stroke-width:2px
    style D fill:#000000,stroke:#333,stroke-width:1px
    style E fill:#000000,stroke:#333,stroke-width:1px
    style F fill:#000000,stroke:#333,stroke-width:1px
    style G fill:#000000,stroke:#333,stroke-width:1px
    style H fill:#000000,stroke:#333,stroke-width:2px
    style I fill:#000000,stroke:#333,stroke-width:2px
    style J fill:#000000,stroke:#333,stroke-width:2px
