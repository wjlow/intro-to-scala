wartremoverErrors in (Compile, compile) ++= Seq(Wart.Any,
                                                Wart.AnyVal,
                                                Wart.AsInstanceOf,
                                                Wart.IsInstanceOf,
                                                Wart.Null,
                                                Wart.Return,
                                                Wart.Var,
                                                Wart.Throw)
