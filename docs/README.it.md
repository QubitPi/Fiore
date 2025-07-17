Documentazione di Fiore
=======================

Un altro ottimo modo per contribuire a Fiore è aiutarci a scrivere e gestire la nostra documentazione.

Fiore segue la filosofia ["docs as code"](https://writethedocs.qubitpi.org/en/latest/guide/docs-as-code/), il che
significa che utilizziamo gli stessi strumenti per gestire e integrare/convertire il nostro codice e la nostra
documentazione. Pertanto, la documentazione viene gestita direttamente all'interno del codice di Fiore in `docs/`.
Questa [documentazione](http://fiore.qubitpi.org/) è stata creata utilizzando
[Docusaurus](https://docusaurus.qubitpi.org/), un moderno generatore di siti web statici.

Markdown
--------

La nostra documentazione è scritta in [Markdown](https://en.wikipedia.org/wiki/Markdown), un linguaggio di markup per la
scrittura di contenuti tecnici. Markdown supporta molte funzionalità avanzate, come il collegamento affidabile tra
diversi set di documentazione, pur rimanendo leggibile.

Sebbene Fiore sfrutti molte di queste funzionalità, non è necessario essere esperti di Markdown per contribuire alla
nostra documentazione. In effetti, un paio di semplici regole tratte dalla nostra
[guida per contribuire](https://fiore.qubitpi.org/docs/contributing/markdown-documentation-style-guide) sono più che
sufficienti per iniziare.

Sviluppo locale
---------------

Per creare la documentazione in locale, dobbiamo prima assicurarci che Node sia
[installato](https://nodesource.com/products/distributions) e quindi eseguire il seguente comando dalla cartella `doc`
del progetto Fiore:

```console
yarn
```

La documentazione viene gestita come un'unità separata all'interno di Fiore, il che significa che possiamo crearla
separatamente dal resto del progetto. Quindi possiamo usare il seguente comando per avviare un server di sviluppo locale
che, quando pronto, aprirà automaticamente una finestra del browser:

```console
yarn start
```

Si noti che la maggior parte delle modifiche viene applicata in tempo reale senza dover riavviare il server.

CI/CD
-----

```console
yarn build
```

Questo comando genera contenuto statico nella directory `build` e può essere servito tramite qualsiasi servizio di
hosting di contenuti statici.

Internazionalizzazione
-------------------

Una volta aggiornata la meta-configurazione di Docusaurus, il corrispondente i18n può essere
[rilevato e configurato automaticamente](https://docusaurus.qubitpi.org/docs/i18n/tutorial#translate-plugin-data) con

```console
yarn write-translations --locale it
```

> [!IMPORTANTE]
>
> Sarebbe comunque necessario tradurre manualmente il contenuto, ad esempio traducendo i
> [campi `message` generati automaticamente](i18n/it/docusaurus-plugin-content-docs/current.json)
