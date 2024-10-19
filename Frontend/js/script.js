document.getElementById('startButton').addEventListener('click', function() {
    const output = document.getElementById('output');
    const ctx = document.getElementById('myChart').getContext('2d');
    const dataPoints = []; // Array para almacenar las alturas
    const labels = [];     // Array para almacenar los nombres de las especies

    // Inicializar el gráfico
    const myChart = new Chart(ctx, {
        type: 'bar', // Tipo de gráfico
        data: {
            labels: labels, // Etiquetas del eje X
            datasets: [{
                label: 'Height (m)',
                data: dataPoints,
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

    // Leer el archivo CSV
    fetch('data/biological_data.csv')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.text();
        })
        .then(data => {
            const rows = data.split('\n').slice(1); // Ignorar la primera fila (encabezados)

            // Simular procesamiento en tiempo real
            rows.forEach((row, index) => {
                setTimeout(() => {
                    const values = row.split(',');
                    if (values.length > 0) {
                        const species = values[1]; // Nombre de la especie
                        const height = parseFloat(values[2]); // Altura en metros

                        // Agregar datos al gráfico
                        labels.push(species);
                        dataPoints.push(height);
                        myChart.update(); // Actualizar el gráfico en tiempo real
                        output.textContent += `Processing data: ${species} - Height: ${height} m\n`; // Mostrar en la terminal
                    }
                }, index * 1000); // Procesar cada especie con un retraso de 1 segundo
            });
        })
        .catch(error => {
            console.error('Error al leer el CSV:', error);
            output.textContent += 'Error al leer el CSV: ' + error.message + '\n'; // Mostrar error en el área de salida
        });
});
