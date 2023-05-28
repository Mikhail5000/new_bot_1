require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: Hello
        intent!: /привет
        q!: * (привет/здравствуй*/~добрый (~утро/~вечер/~день/~ночь)/hello/hi) *
        a: Привет!
        
    state: Weather
        intent!: /погода
        q!: * (погода/weather/на улице) *
        a: Сегодня облачно, возможны осадки в виде фрикаделек

    state: Currency
        intent!: /курс валют
        q!: * (валют/курс/currency) *
        a: На рынке все хорошо! Доллар и Евро ниже 100

    state: Bye
        intent!: /пока
        a: Пока пока

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: Я понял. Вы сказали: {{$context.intent.answer}}