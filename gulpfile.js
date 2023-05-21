const gulp = require('gulp');
const sass = require('gulp-sass')(require('sass'));
const autoprefixer = require('gulp-autoprefixer');
const rename = require('gulp-rename');

// Tarea para compilar los estilos SCSS
gulp.task('styles', function() {
    return gulp.src('src/main/resources/static/stylesheet.scss')
        .pipe(sass({ outputStyle: 'compressed' }).on('error', sass.logError))
        .pipe(autoprefixer())
        .pipe(rename({ suffix: '.min' }))
        .pipe(gulp.dest('src/main/resources/static/style.css'))
});

// Tarea para vigilar los cambios en los archivos SCSS y JS
gulp.task('watch', function() {
    gulp.watch('src/main/resources/static/stylesheet.scss', gulp.series('styles'));
});

// Tarea predeterminada que se ejecuta al escribir 'gulp' en la terminal
gulp.task('default', gulp.series('styles', 'watch'));
