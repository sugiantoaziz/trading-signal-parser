# trading-signal-parser
parse trading signal message via rest request

A simple Java Spring REST to parse twitter message, specially trading signal tweets.

1. Put your Twitter API token in com.lumbu.tradingsignalparser.service.impl.TwitterServiceImpl line 36

2. Compile this project with Java 8:
mvn clean package

3. Run the compiled jar using this command:
java -jar trading-signal-parser

4. Open postman to test this sample request:
localhost:8787/parser/requestSignal?screen_names=forex1997,last_news_q8&count=1
substitute screen_names with twitter account(s), and count with the number of tweets to gather.

5. Create Java class for your prefered trading signal account(s) in this package com.lumbu.tradingsignalparser.helper.dp.impl

6. Call the REST URL through your customized MetaTrader EA.

7. That's it... happy trading, guys!
