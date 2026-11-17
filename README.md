# ⚡ PokeHub — Pokémon Information System

> Aplicação de linha de comando (CLI) desenvolvida em Java para exploração e consulta de dados do universo Pokémon em tempo real através da [PokeAPI](https://pokeapi.co/).

---

## 🎯 Sobre o Projeto

O **PokeHub** nasceu como um projeto prático focado na consolidação de conceitos fundamentais do desenvolvimento back-end em Java, como consumo de APIs REST, desserialização de objetos JSON aninhados, manipulação de coleções e organização de código em camadas.

A interface em terminal foi projetada com códigos de escape ANSI e bordas ASCII para proporcionar uma navegação clara, intuitiva e visualmente agradável.

---

## ✨ Funcionalidades Atuais

- **🔎 Busca & Pokédex Interativa:**
  - Listagem paginada de Pokémon com navegação dinâmica (`offset` e `limit`).
  - Consulta direta pelo nome do Pokémon.
- **📋 Ficha Técnica Detalhada:**
  - Exibição organizada de atributos base, tipos, habilidades, cadeia evolutiva, golpes e descrições da Pokédex.
- **ℹ️ Painel Institucional:**
  - Tela dedicada às informações de arquitetura, tecnologias e roadmap do projeto.

---

## 🏗️ Arquitetura do Projeto

O código foi estruturado separando responsabilidades para facilitar a manutenção e futuras expansões:

```text
src/
 ├── controller/
 │    └── NavigationController.java   # Controle de estado da paginação e fluxo de telas
 ├── model/
 │    ├── Pokemon.java                # Modelos de domínio para mapeamento JSON (DTOs)
 │    ├── Species.java
 │    ├── EvolutionChain.java
 │    └── ...
 ├── service/
 │    └── ApiService.java             # Comunicação assíncrona com a PokeAPI via HttpClient
 ├── ui/
 │    └── ConsoleMenu.java            # Renderização de menus, tabelas ASCII e entradas do usuário
 └── Main.java                        # Ponto de entrada da aplicação
```

---

## 🛠️ Tecnologias Utilizadas

- **Java** (POO, Collections, Scanner)
- **Java `HttpClient`** (Requisições HTTP assíncronas)
- **Jackson Databind** (Desserialização de JSON complexo para objetos Java)
- **PokeAPI v2** (Fonte de dados externa)

---

## 🚀 Como Executar Localmente

### Pré-requisitos
- **JDK 17+** instalado
- Biblioteca **Jackson Databind** configurada no classpath (ou via gerenciador de dependências)
- Terminal com suporte a cores ANSI (ex: terminal integrado do IntelliJ IDEA, Windows Terminal, Linux/macOS)

### Passos
1. Clone o repositório:
   ```bash
   git clone [https://github.com/seu-usuario/PokeHub.git](https://github.com/seu-usuario/PokeHub.git)
   ```
2. Abra o projeto na sua IDE Java de preferência (ex: IntelliJ IDEA).
3. Certifique-se de que as dependências do Jackson na pasta `lib/` estão adicionadas ao projeto.
4. Execute a classe `src/Main.java`.

---

## 🔄 Roadmap (Próximas Atualizações)

Este projeto está em constante evolução conforme o avanço nos estudos da trilha Java:

- [ ] **Persistência Local:** Salvar e gerenciar uma lista de Pokémons favoritos / time em arquivo `.json`.
- [ ] **Tratamento Avançado de Erros:** Exceções customizadas para validação de status HTTP (ex: `404 Not Found`) e entradas inválidas.
- [ ] **Cache em Memória:** Armazenar consultas recentes com `HashMap` para reduzir chamadas repetidas à API.

---

## 👨‍💻 Autor

Desenvolvido por **Luan** como projeto prático de portfólio em Java.