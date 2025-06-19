---
sidebar_position: 1
title: Flusso di lavoro PR per la revisione del codice
---

La revisione del codice tramite Pull Request (PR) è un aspetto importante dello sviluppo perché è uno dei principali
canali di comunicazione delle modifiche apportate al codice sorgente a tutti gli altri che ci lavorano. Determinare lo
stato di una PR, tuttavia, non è sempre facile, soprattutto per le PR molto attive con molti commenti e discussioni.
Questo documento descrive come utilizziamo le etichette di GitHub per contrassegnare lo stato di una PR, rendendone
facile la verifica a colpo d'occhio. Descrive anche cosa rende una PR facile da revisionare (e più una PR è facile da
revisionare, più velocemente verrà integrata!).

Cosa rende una PR buona?
------------------------

Lo scopo della revisione del codice e dell'apertura di una richiesta di rilascio (PR) è duplice:

1. Modificare Fiore, compito dell'autore delle modifiche
2. Garantire che le modifiche nella PR migliorino Fiore, compito dei revisori della PR

### Tipi di modifiche

I tipi di modifiche apportate a Fiore sono solitamente di pochi tipi principali:

1. __Cleanup__: queste rientrano in 3 categorie:

   1. Modifiche stilistiche che rendono il codice più facile da leggere e meglio allineato con il resto della base di
      codice.
   2. Modifiche di refactoring che migliorano il codice riducendo le duplicazioni o ripulendo classi e astrazioni che
      potrebbero aver avuto troppe responsabilità.
   3. Modifiche per aggiungere o migliorare i test per coprire comportamenti non testati o renderli più chiari.

2. __Logiche__: queste sono modifiche che aggiungono funzionalità e capacità che Fiore non aveva prima, o forse cambiano
   il modo in cui funzionano funzionalità, capacità e caratteristiche esistenti.

### Organizzazione delle modifiche

Sebbene la maggior parte delle modifiche inviate siano modifiche logiche, le modifiche di pulizia sono molto benvenute.
Quando si apportano modifiche di pulizia, tuttavia, seguire alcune piccole linee guida garantirà che le modifiche siano
facili da esaminare per i revisori delle PR:

1. Le modifiche _dovrebbero_ migliorare il codice secondo le [buone linee guida di stile](https://google.github.io/styleguide/javaguide.html).
2. Le modifiche _non dovrebbero_ oscurare altre modifiche, in particolare quelle logiche.

   - È meglio avere le modifiche di pulizia come PR separate, o almeno come commit separati dai commit con modifiche
     logiche. (PR separate sono fortemente preferite)
   - È meglio avere troppi commit piccoli che devono essere raggruppati piuttosto che troppi pochi commit grandi che
     presentano modifiche sovrapposte. I commit piccoli possono essere combinati più facilmente di quanto i commit
     grandi possano essere divisi.

### Documentazione delle modifiche

In alcuni casi, quali siano le modifiche e perché vengano apportate sono evidenti, ma in molti casi non è chiaro quale
sia lo spirito della modifica. Pertanto, per facilitare la comprensione da parte dei revisori di quali siano le
modifiche e perché vengano apportate, si prega di descriverle nella descrizione della richiesta di pubblicazione. È
inoltre consigliabile rivedere le proprie richieste di pubblicazione e lasciare commenti ove le modifiche richiedano
ulteriori spiegazioni. Ricordate, ___è compito dell'autore semplificare la revisione delle modifiche per i revisori!___

Fasi
----

Quando una richiesta di pubblicazione passa dall'essere aperta all'essere unita o chiusa, attraversa diversi stati o
fasi, fino a diventare chiusa o unita.

- [Work in Progress (WIP)](#work-in-progress-wip)
- [Reviewable](#reviewable)
- [Mergeable](#mergeable)
- [Merged*](#merged)
- [Closed*](#closed)

<sub>* indica gli stati predefiniti di GitHub per le PR. </sub>

### Work in Progress (WIP)

Le modifiche alla PR vengono apportate attivamente, spesso in risposta al feedback dei revisori o per consentire un
feedback su un lavoro parziale. Sentiti libero di revisionarlo, ma il codice non è considerato completo dall'autore e
probabilmente richiederà una nuova revisione una volta completato il lavoro in corso.

### Reviewable

L'autore considera le modifiche complete e pronte per la revisione completa.

### Mergeable

Una volta che una PR ha superato questa serie di controlli, è unificabile ed è pronta per essere [Merged*](#merged):

- Le modifiche sono state approvate da almeno 2 revisori
- Le modifiche si basano sulla testa del branch `master`
- I commit sono stati compressi in commit logici

### Merged*

La PR è stata unita. Questo è uno stato predefinito della PR di GitHub e _dovrebbe_ coesistere con lo stato
[Mergeable](#mergeable).

### Closed*

Le modifiche non verranno unite e la PR non dovrebbe ricevere ulteriore attenzione. Le PR chiuse possono essere riaperte.

Flusso
------

Sebbene non vi siano restrizioni sugli stati, poiché sono indicati solo da etichette, questa tabella descrive in
dettaglio le transizioni di stato previste da una fase all'altra.

| Inizio                                    | Fine                                                                                     |
|-------------------------------------------|------------------------------------------------------------------------------------------|
| -                                         | [Work in Progress](#work-in-progress-wip), [Reviewable](#reviewable), [Closed*](#closed) |
| [Work in Progress](#work-in-progress-wip) | [Reviewable](#reviewable), [Closed*](#closed)                                            |
| [Reviewable](#reviewable)                 | [Work in Progress](#work-in-progress-wip), [Mergeable](#mergeable), [Closed*](#closed)   |
| [Mergeable](#mergeable)                   | [Merged*](#merged), [Closed*](#closed)                                                   |
| [Merged*](#merged)                        | -                                                                                        |
| [Closed*](#closed)                        | [Work in Progress](#work-in-progress-wip), [Reviewable](#reviewable)                     |

Flag
-----

A seconda delle modifiche, di ciò che è accaduto nel repository al di fuori della PR e della fase del processo in cui si
trova la PR, possono essere applicati diversi flag alla PR. Alcuni flag indicano aspetti delle modifiche, mentre altri
indicano ciò che deve essere fatto ai commit o alle modifiche nella PR prima che questa possa essere considerata
[Mergeable](#mergeable).

- [Breakfix](#breakfix)
- [Breaking Change](#breaking-change)
- [Need 2 Reviews](#need-2-reviews)
- [Need 1 Review](#need-1-review)
- [Need Changes](#need-changes)
- [Need Rebase](#need-rebase)
- [Need Squash](#need-squash)

### Breakfix

Le modifiche nella PR sono urgentemente necessarie per correggere una release non funzionante. Le release non
funzionanti dovrebbero essere corrette il più rapidamente possibile, quindi alle PR `Breakfix` dovrebbe essere data una
priorità maggiore rispetto alle altre PR.

### Breaking Change

Le modifiche nella PR sono retrocompatibili con le API rivolte ai clienti. Queste API non sono attualmente documentate,
ma quando lo saranno, saranno linkate qui. Nel frattempo, l'elenco operativo delle API rivolte al cliente include:

- Formati di risposta (inclusi gli header)
- Formati di richiesta (inclusi URL, parametri della stringa di query e header)
- Configurazione (inclusi nomi di proprietà, classi helper e interfacce)
- Query LLM (ad es. OpenAI)

### Need 2 Reviews

Sono necessarie altre 2 approvazioni prima che la richiesta di pubblicazione possa essere considerata
[Mergeable](#mergeable).

### Need 1 Review

È necessaria un'altra approvazione prima che la richiesta di pubblicazione possa essere considerata
[Mergeable](#mergeable).

### Need Changes

I revisori della richiesta di pubblicazione ritengono che siano ancora necessarie modifiche prima di poterla approvare.
Qualsiasi revisore che richieda modifiche in un commento deve assicurarsi che questo tag venga applicato alla richiesta
di pubblicazione e l'autore della richiesta di pubblicazione deve rimuoverlo quando ritiene di aver apportato tutte le
modifiche necessarie.

### Need Rebase

Le modifiche devono essere rebase sul ramo principale del ramo `master` prima che la PR possa essere considerata
[Mergeable](#mergeable).

### Need Squash

Le modifiche devono essere compresse in commit logici prima che la PR possa essere considerata [Mergeable](#mergeable).

__Nota: una PR che non ha ottenuto le due approvazioni necessarie non deve essere compressa.__ Tutti i commit effettuati
in risposta ai commenti di revisione devono essere lasciati sul ramo fino al completamento della revisione, in modo che
sia facile per i revisori tenere traccia delle modifiche apportate in risposta ai loro commenti.
