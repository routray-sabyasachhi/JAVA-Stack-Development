document.addEventListener("DOMContentLoaded", function () {
    if (!window.Typed) {
        return;
    }

    new Typed("#element", {
        strings: [
            "Full Stack Developer",
            "Java Developer",
            "Problem Solver",
            "DSA Enthusiast"
        ],
        typeSpeed: 60,
        backSpeed: 40,
        backDelay: 1800,
        loop: true
    });
});
