//
//  JMamagerCell.swift
//  Content
//
//  Created by fcn on 2018/10/11.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit

class JMamagerCell: UITableViewCell {
    
    
    
    @IBOutlet weak var img: UIImageView!
    

    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
        
        img.layer.masksToBounds = true
        
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
