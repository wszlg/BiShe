//
//  NetTool.swift
//  Content
//
//  Created by fcn on 2018/10/9.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit
import Alamofire
import SwiftyJSON

class NetTool: NSObject {
    
    
    
    static func Get(url: String, parameters: Parameters?, completionHandler: @escaping (JSON?) -> Void)  {
        
        Alamofire.request(url, method: .get, parameters: parameters, encoding: URLEncoding.default, headers: nil).response { (response) in
            if response.response?.statusCode == 200 {
                if let d = response.data{
                    let json = JSON(d)
                    completionHandler(json)
                }
            } else {
                completionHandler(nil)
            }
        }
        
    }

}
