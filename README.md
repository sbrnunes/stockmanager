# stockmanager

Spring boot

Spring data - Elasticsearch

Spring MVC
 /product

# Elasticsearch

Is expecting to see the server as localhost:9300 see application.properties

See http://www.elastic.co/guide/en/elasticsearch/reference/current/setup-service-win.html for windows installation and
service configuration.

For browser database search see https://github.com/mobz/elasticsearch-head

# Running Elasticsearch on Mac OS X

Install using brew:

brew update
brew install elasticsearch

After installing: 
To have launchd start elasticsearch at login:
    ln -sfv /usr/local/opt/elasticsearch/*.plist ~/Library/LaunchAgents
Then to load elasticsearch right away:
    launchctl load ~/Library/LaunchAgents/homebrew.mxcl.elasticsearch.plist
Or, if you don't want/need launchctl, you can just run:
    elasticsearch --config=/usr/local/opt/elasticsearch/config/elasticsearch.yml
