import requests
from dataclasses import dataclass
from datetime import datetime, timedelta, date
from typing import List
import json


@dataclass
class PreviredResponse:
    id: int
    fechaCreacion: date
    fechaFin: date
    fechas: List[date]
    fechasFaltantes: List[date]


headers = {
    'Accept': 'application/json',
}

def dateRange(startDate, endDate):
    for n in range(int((endDate-startDate).days)):
        yield startDate + timedelta(n)


def calculateMissingPeriods(obj):
    startDate = obj.fechaCreacion
    endDate = obj.fechaFin
    list1 = obj.fechas
    list2 = []

    for singleDate in dateRange(datetime.strptime(startDate, '%Y-%m-%d'), datetime.strptime(endDate, '%Y-%m-%d')):
        if (singleDate.day == 1 ):
            list2.append(singleDate.strftime('%Y-%m-%d'))

    listaFinal = [e for e in list2 if e not in list1]

    if(listaFinal[-1] != endDate or list1 != endDate):
        listaFinal.append(endDate)
    obj.fechasFaltantes = listaFinal

try:
    response = requests.get('http://127.0.0.1:8080/periodos/api', headers=headers)
    parseResponse = response.json()
    obj = PreviredResponse(id=parseResponse["id"], fechaCreacion=parseResponse['fechaCreacion'], fechaFin=parseResponse['fechaFin'], fechas=parseResponse['fechas'], fechasFaltantes=[])
    calculateMissingPeriods(obj)
    jsonStr = json.dumps(obj.__dict__)
    print(jsonStr)

except requests.ConnectionError:
    print('Error de conexión, por favor contáctese con su área de soporte')