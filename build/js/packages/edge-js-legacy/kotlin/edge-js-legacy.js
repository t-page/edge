(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', 'kotlin'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('kotlin'));
  else {
    if (typeof kotlin === 'undefined') {
      throw new Error("Error loading module 'edge-js-legacy'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'edge-js-legacy'.");
    }root['edge-js-legacy'] = factory(typeof this['edge-js-legacy'] === 'undefined' ? {} : this['edge-js-legacy'], kotlin);
  }
}(this, function (_, Kotlin) {
  'use strict';
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var Kind_OBJECT = Kotlin.Kind.OBJECT;
  Some.prototype = Object.create(Option.prototype);
  Some.prototype.constructor = Some;
  None.prototype = Object.create(Option.prototype);
  None.prototype.constructor = None;
  function Option() {
  }
  Option.prototype.fold_9dmrm4$ = function (someFunction, noneFunction) {
    if (Kotlin.isType(this, Some))
      someFunction();
    else if (Kotlin.isType(this, None))
      noneFunction();
  };
  Option.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Option',
    interfaces: []
  };
  function Some(value) {
    Option.call(this);
    this.value = value;
  }
  Some.prototype.show = function () {
    return this.value;
  };
  Some.prototype.map_2o04qz$ = function (f) {
    return createSome(f(this.value));
  };
  Some.prototype.flatMap_lv4vfh$ = function (f) {
    return f(this.value);
  };
  Some.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Some',
    interfaces: [Option]
  };
  Some.prototype.component1 = function () {
    return this.value;
  };
  Some.prototype.copy_11rb$ = function (value) {
    return new Some(value === void 0 ? this.value : value);
  };
  Some.prototype.toString = function () {
    return 'Some(value=' + Kotlin.toString(this.value) + ')';
  };
  Some.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.value) | 0;
    return result;
  };
  Some.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && Kotlin.equals(this.value, other.value))));
  };
  function None() {
    None_instance = this;
    Option.call(this);
  }
  None.prototype.show = function () {
    return null;
  };
  None.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'None',
    interfaces: [Option]
  };
  var None_instance = null;
  function None_getInstance() {
    if (None_instance === null) {
      new None();
    }return None_instance;
  }
  function optionFrom(value) {
    var tmp$;
    if (value == null)
      tmp$ = None_getInstance();
    else
      tmp$ = new Some(value);
    return tmp$;
  }
  function createSome(value) {
    return new Some(value);
  }
  var package$effects = _.effects || (_.effects = {});
  package$effects.Option = Option;
  package$effects.Some = Some;
  Object.defineProperty(package$effects, 'None', {
    get: None_getInstance
  });
  package$effects.optionFrom_mh5how$ = optionFrom;
  package$effects.createSome_mh5how$ = createSome;
  Kotlin.defineModule('edge-js-legacy', _);
  return _;
}));

//# sourceMappingURL=edge-js-legacy.js.map
