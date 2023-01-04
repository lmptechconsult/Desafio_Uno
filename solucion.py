from dateutil.rrule import rrule, MONTHLY

def meses_faltantes(response):
    fecha_inicio = response['fechaCreacion']
    fecha_fin = response['fechaFin']
    fechas = response['fechas']
    meses_faltantes = []

    # Calcular todos los meses entre fecha_inicio y fecha_fin
    meses = list(rrule(MONTHLY, dtstart=fecha_inicio, until=fecha_fin))

    # Verificar si cada mes está en la lista de fechas obtenidas del servicio
    for mes in meses:
        if mes.strftime("%Y-%m-%d") not in fechas:
            meses_faltantes.append(mes.strftime("%Y-%m-%d"))

    return meses_faltantes
