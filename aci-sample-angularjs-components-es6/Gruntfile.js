module.exports = function (grunt) {

    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-browserify');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-contrib-connect');
    grunt.loadNpmTasks('grunt-karma');

    grunt.initConfig({

        // jshint(static code analysis)
        jshint: {
            options: {
                curly: true,
                eqeqeq: true,
                esversion: 6
            },
            target1: ['src/**/*.js'],
            target2: ['Gruntfile.js']
        },

        // browserify (ES6 --> ES5 transpilation)
        browserify: {
            dist: {
                options: {
                    transform: [
                        ['babelify', {presets: ['es2015']}],
                        ['stringify', ['.html']],
                        ['browserify-css']
                    ],
                    browserifyOptions: {debug: true},
                    watch: true,
                    keepAlive: false
                },
                src: ['src/app.module.js'],
                dest: 'build/bundle.js'
            }
        },

        // copy (static files: index.html)
        copy: {
            html: {
                files: {
                    'build/index.html': 'src/index.html'
                }
            }
        },

        // watch
        watch: {
            options: {
                atBegin: false,
                livereload: true
            },
            html_src: {
                files: 'src/index.html',
                tasks: ['copy'],
            },
            js_build: {
                files: ['build/*.js'],
                tasks: []
            },
            jshint: {
                files: ['src/**/*.js'],
                tasks: ['jshint']
            }

        },

        // connect (local http web server)
        connect: {
            server: {
                options: {
                    hostname: 'localhost',
                    livereload: true,
                    keepAlive: true,
                    port: 9001,
                    base: 'build',
                    open: true
                }
            },
            proxies: [
                {
                    context: '/api/**',
                    host: 'localhost',
                    port: 8080,
                    https: false,
                    xforward: false
                }
            ]
        },

        // karma
        karma: {
            unit: {
                configFile: 'karma.conf.js',
                background: true
            }
        }

    });

    grunt.registerTask('build', ['jshint', 'copy', 'browserify']);

    grunt.registerTask('default', ['build', 'karma', 'connect', 'watch']);

};