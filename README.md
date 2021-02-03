# trading-signal-parser
parse trading signal message via rest request

A simple Java Spring REST to parse twitter message, specially trading signal tweets.
1. Compile this project with Java 8:
mvn clean package

2. Run this command in your CLI:
java -jar trading-signal-parser

3. Open postman to test this sample request:
localhost:8787/parser/requestSignal?screen_names=forex1997,last_news_q8&count=1
substitute screen_names with twitter account(s), and count with the number of tweets to gather.

4. Call the REST URL through your customized MetaTrader EA.

5. That's it... happy trading, guys!
