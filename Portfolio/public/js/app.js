// On sélectionne les sections et les cartes projets
const elementsToAnimate = document.querySelectorAll('section, .carte-projet');

const observer = new IntersectionObserver((entries) => {
    entries.forEach((entry) => {
        // Dès qu'un élément entre dans l'écran
        if (entry.isIntersecting) {
            entry.target.classList.add('visible'); // On ajoute la classe CSS qui rend visible
            observer.unobserve(entry.target); // On arrête de surveiller cet élément
        }
    });
}, {
    threshold: 0.1 // L'animation se déclenche quand 10% de l'élément est visible
});

// On active la surveillance
elementsToAnimate.forEach((element) => {
    observer.observe(element);
});