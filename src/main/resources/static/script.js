document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.dropdown-trigger');
    const options = {
        constrainWidth: false,
        coverTrigger: false
    }
    var instances = M.Dropdown.init(elems, options);
});