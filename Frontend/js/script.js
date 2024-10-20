// Función para obtener y actualizar el gráfico con métricas de los hilos
document.getElementById('startButton').addEventListener('click', async () => {
    try {
        // Hacer la solicitud al backend para obtener las métricas de los hilos
        const response = await fetch('/api/thread-metrics');
        const threadMetrics = await response.json();

        // Obtener nombres de los hilos y tiempos de procesamiento
        const labels = threadMetrics.map(metric => metric.threadName);
        const data = threadMetrics.map(metric => metric.processingTime);

        // Crear o actualizar el gráfico de hilos
        const ctx = document.getElementById('myChart').getContext('2d');
        const myChart = new Chart(ctx, {
            type: 'bar', // Tipo de gráfico
            data: {
                labels: labels, // Nombres de los hilos
                datasets: [{
                    label: 'Processing Time (ms)', // Etiqueta del gráfico
                    data: data, // Tiempos de procesamiento de los hilos
                    backgroundColor: 'rgba(75, 192, 192, 0.2)', // Color de las barras
                    borderColor: 'rgba(75, 192, 192, 1)', // Color del borde de las barras
                    borderWidth: 1 // Grosor del borde
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true // Comenzar el eje Y desde cero
                    }
                }
            }
        });

        // Mostrar la salida en el área de preformateado
        document.getElementById('output').textContent = 'Thread metrics updated successfully!';
    } catch (error) {
        console.error('Error fetching thread metrics:', error);
        document.getElementById('output').textContent = 'Error fetching thread metrics';
    }
});
