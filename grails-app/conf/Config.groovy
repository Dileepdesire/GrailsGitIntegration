import org.scribe.builder.api.GitHubApi;

// locations to search for config files that get merged into the main config;


// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }


grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [
    all:           '*/*',
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console appender:
    //debug 'org.springframework.security'
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
           'org.codehaus.groovy.grails.web.pages',          // GSP
           'org.codehaus.groovy.grails.web.sitemesh',       // layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping',        // URL mapping
           'org.codehaus.groovy.grails.commons',            // core / classloading
           'org.codehaus.groovy.grails.plugins',            // plugins
           'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
}


// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'org.lftech.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'org.lftech.UserRole'
grails.plugin.springsecurity.authority.className = 'org.lftech.Role'
grails.plugin.springsecurity.auth.loginFormUrl = '/'
grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/hom'
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.failureHandler.defaultFailureUrl  = '/'



oauth {
	providers {
		github {
			api = GitHubApi
			key = 'b7e55396d2959448544f'
			//'42e51296f11550cd416d'
			//'a3d709d5a7ec544e4908'
			secret = '28d5bfbb55314d6e2815ac5e1ee370567b7c8445'
			//'ba9814fd4f4c6c8b965e8b99741fba8ae4948735'
			//'293625174412511fbdc59025993417c53696ebd5'
			successUri = '/hom/success'
			failureUri = '/hom/failure'
			scope='repo,public_repo,user:email,write:org,write:public_key,write:repo_hook,notifications,repo:status,delete_repo,user:follow,read:org,read:public_key,read:repo_hook,repo_deployment,user,admin:org,admin:public_key,admin:repo_hook,gist'
			callback='http://localhost:8080/test/hom/callback'
		}
	}
	debug = true
}



grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	'/':                               ['permitAll'],
	'https://api.github.com/**': ['permitAll'],
	
	'/index':                         ['permitAll'],
	'/index.gsp':                     ['permitAll'],
	'/assets/**':					  ['permitAll'],
	'/**/js/**':                      ['permitAll'],
	'/**/css/**':                     ['permitAll'],
	'/**/images/**':                  ['permitAll'],
	'/**/favicon.ico':                ['permitAll'],
	'/quote/login':                   ['permitAll'],
	'/logout/**':                     ['permitAll'],
	'/oauth/**':                      ['ROLE_ADMIN'],
	'/business/**':                      ['ROLE_ADMIN'],
	'/hom/**':                      ['ROLE_ADMIN'],
	
	
	
]



