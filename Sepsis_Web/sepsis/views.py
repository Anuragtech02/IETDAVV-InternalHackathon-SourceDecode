from django.shortcuts import render
from django.http import HttpResponse

def home(request):
    return render(request,"home.html")
def p(request):
    return render(request,"prevention.html")    