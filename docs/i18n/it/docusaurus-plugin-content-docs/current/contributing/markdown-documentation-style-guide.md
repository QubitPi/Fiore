---
sidebar_position: 2
title: Guida di stile per la documentazione in Markdown
---

Markdown è ottimo per scrivere documentazione. GitHub lo visualizza in modo nativo in modo molto gradevole e coerente, è
facilmente visualizzabile in diversi altri formati ed è facile da leggere quando non è visualizzato (ad esempio come
testo). Come per qualsiasi cosa che supporti la formattazione avanzata, tuttavia, il formato migliore non è sempre
chiaro, e comprendere la documentazione è particolarmente difficile quando non viene utilizzato uno stile chiaro e
coerente in tutta la documentazione.

Per assicurarsi che tutta la documentazione in Fiore sia sulla stessa pagina (non letteralmente...), ecco alcune linee
guida generali per la formattazione in Markdown:

Utilizzare la formattazione a livello di blocco con giudizio
--------------------------------------

- Le intestazioni forniscono una panoramica del contenuto di un documento e forniscono indicazioni ai lettori. Usatele!

  - Le intestazioni H1 e H2 dovrebbero essere definite da sottolineature (rispettivamente `===` e `---`) anziché da
    cancelletti antecedenti (`#`).
  - Per le intestazioni definite da sottolineature, queste devono avere lo stesso numero di caratteri del testo
    dell'intestazione.
  - Per le intestazioni definite da cancelletti antecedenti, gli hash finali sono facoltativi, ma il numero di hash
    finali deve corrispondere a quello degli hash precedenti, se presenti.

- Se si cita da un'altra fonte, utilizzare un blockquote (`>` all'inizio della riga).
- Un esempio di codice (in un blocco di codice) è spesso il modo migliore per illustrare qualcosa o mostrare un esempio.
  Usatelo liberamente!
- Gli elenchi sono ottimi per suddividere le informazioni in blocchi più piccoli e facili da assimilare.

  - Utilizzare rientri sporgenti per gli elementi di elenchi multi-riga.
  - Gli elenchi "tipo intestazione" possono utilizzare il __grassetto__ per trasformare gli elementi principali
    dell'elenco in "pseudo-intestazioni", se necessario. In generale, è meglio utilizzare le intestazioni vere e
    proprie, ma non funzionano sempre bene (soprattutto se sono molto lunghe).
  - Gli elenchi in stile "Elenco di definizioni" possono utilizzare il __grassetto__ per separare il termine o la frase
    dalla definizione.

Rendere i documenti interattivi collegandoli ad altri elementi
--------------------------------------------------------------

- Creare collegamenti ad altre parti del documento (ad esempio, intestazioni o sezioni) o ad altri documenti o risorse.
- Includere una sezione Indice per documenti lunghi o complessi.
- Collegare test o codice vero e proprio all'interno della base di codice è un ottimo modo per mostrare un esempio di
  qualcosa.
- Non affidarsi al collegamento automatico degli URL. Utilizzare il testo della documentazione per dare al collegamento
  un nome più descrittivo. - I link devono usare lo stile di riferimento:

  ```markdown
  [testo del link][riferimento al link]
  [testo del link di esempio][link di esempio]

  [riferimento al link]: <URL effettivo>
  [link di esempio]: http://example.com
  ```

  piuttosto che lo stile in-line:

  ```markdown
  [example](http://example.com)
  ```

- I riferimenti ai link devono essere organizzati in fondo al documento in ordine alfabetico, con una
  riga vuota tra ogni lettera dell'alfabeto:

  ```markdown
  [un link di esempio]: http://example.com
  [un altro link di esempio]: http://example.com

  [sii il link di esempio che avresti dovuto essere]: http://example.com

  [link di esempio]: http://example.com
  ```

- I link in-line possono essere utilizzati per creare collegamenti ad altri documenti Markdown nella stessa posizione.
  Ad esempio:

  ```markdown
  [link di esempio](sibling-document)
  ```

- I riferimenti devono essere specificati esplicitamente. I seguenti hanno tutti lo stesso significato nel GitHub
  flavoured Markdown:

  ```markdown
  [link di esempio][link di esempio] <-- Preferito
  [link di esempio]
  [link di esempio][]

  [link di esempio]: http://example.com
  ```

  Tuttavia, il primo (che specifica il riferimento esplicitamente) separa il testo del link dal nome del riferimento, ed
  è quindi più resistente alle modifiche.

Usa l'enfasi in modo coerente per evidenziare gli aspetti importanti
--------------------------------------------------------------------

- Le frasi enfatizzate devono essere scritte in _corsivo_ usando un singolo trattino basso (`_`).
- Le informazioni molto importanti, come avvertenze o precauzioni, devono essere scritte in _grassetto__ usando un
  doppio trattino basso (`__`).
- Le informazioni estremamente importanti, come la potenziale perdita di dati o altre informazioni critiche, devono
  essere evidenziate in ___grassetto e corsivo___ utilizzando tre caratteri di sottolineatura (`___`).

Utilizzare le righe vuote con giudizio
---------------------------

- Le intestazioni devono essere seguite da una riga vuota, prima dell'inizio del contenuto della sezione.
- Le intestazioni devono essere precedute da una riga vuota se precedute da altro contenuto.
