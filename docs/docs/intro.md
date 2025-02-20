---
sidebar_position: 1
title: Introduction
---

Getting Started
===============

:::caution

Before proceeding, it is important to note that __we DO NOT support Spring/Spring Boot paradigm__.
[ChatbotWS] runs as a **[JAX-RS]** webservice backed by its reference implementation [Jersey] running
as a WAR inside [Jetty] container.

More info about difference between JAX-RS and Spring can be found in [this thread](https://stackoverflow.com/a/42955575)

:::

To use ChatbotWS as the basis for a webservice, we start by creating a repository using the template on GitHub.

- [Development](development)
- [Configuration](configuration)

[JAX-RS]: https://jcp.org/en/jsr/detail?id=370
[ChatbotWS]: https://chatbot.qubitpi.org/
[Jetty]: https://en.wikipedia.org/wiki/Jetty_(web_server)
