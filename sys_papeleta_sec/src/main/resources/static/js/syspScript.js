$(document).ready(function() {
	
    $('#area').click(function(e) {
        e.preventDefault();
       // alert("mensaje");
        // var idArea = $('select[id=area]').val();
        // alert("area: " + idArea);
    });

    $('#area').change(

        function() {
            $.getJSON("http://localhost:8088/sysp/empleado/listaAjax", {
                //idArea: $(this).val(),
                idArea: $('select[id=area]').val(),
                ajax: 'true'
            }, function(data) {
                var html = '<option value="">--Seleccionar empleado--</option>';
                var len = data.length;
                for (var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].idPersona + '">' +
                        data[i].nombres + " " + data[i].primerApellido + " " + data[i].segundoApellido + '</option>';
                }
                html += '</option>';
                $('#empleado').html(html);
            });
        });
});

function printDiv() {

    var divToPrint = document.getElementById("main");

    var newWin = window.open("", "Print-Window");

    newWin.document.open();

    newWin.document.write("<html><body onload='window.print()'>" + divToPrint.innerHTML + "</body></html>");

    newWin.document.close();

    setTimeout(function() { newWin.close(); }, 10);

}

function PrintElem(elem) {
    var mywindow = window.open('', 'PRINT', 'height=400,width=600');

    mywindow.document.write('<html><head><title>' + document.title + '</title>');
    mywindow.document.write('</head><body >');
    mywindow.document.write('<h1>' + document.title + '</h1>');
    mywindow.document.write(document.getElementById(elem).innerHTML);
    mywindow.document.write('</body></html>');

    mywindow.document.close(); // necessary for IE >= 10
    mywindow.focus(); // necessary for IE >= 10*/

    mywindow.print();
    mywindow.close();

    return true;
}